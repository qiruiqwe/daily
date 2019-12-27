package web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/check-code")
public class CheckCodeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 60;
	private static int HEIGHT = 20;

	public CheckCodeServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("image/jpeg");
		ServletOutputStream sos = response.getOutputStream();

		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();

		char[] rands = generateCheckCode();

		drawBackground(graphics);
		drawRands(graphics, rands);

		graphics.dispose();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpeg", bos);
		byte[] buffer = bos.toByteArray();
		response.setContentLength(buffer.length);

		sos.write(buffer);
		bos.close();
		sos.close();

		session.setAttribute("checkCode", new String(rands));

	}

	private void drawRands(Graphics graphics, char[] rands) {
		graphics.setColor(Color.black);
		graphics.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));

		// 在不同的高度输出验证码的每个字符
		graphics.drawString("" + rands[0], 1, 17);
		graphics.drawString("" + rands[1], 16, 15);
		graphics.drawString("" + rands[2], 31, 18);
		graphics.drawString("" + rands[3], 46, 16);
		//System.out.println(rands);
	}

	private void drawBackground(Graphics graphics) {
		graphics.setColor(new Color(0xdcdcdc));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		// 随机生成120个干扰点
		for (int i = 0; i < 120; i++) {
			int x = (int) (Math.random() * WIDTH);
			int y = (int) (Math.random() * HEIGHT);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			graphics.setColor(new Color(red, green, blue));
			graphics.drawOval(x, y, 1, 0);
		}
	}

	private char[] generateCheckCode() {
		String chars = "0123456789abcdefghijklmnopqrstuvwxyzQWERTYUIOPLKJHGFDSAZXCVBNM";
		char[] rands = new char[4];
		for (int i = 0; i < rands.length; i++) {
			int rand = (int) (Math.random() * 62);
			rands[i] = chars.charAt(rand);
		}
		return rands;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init() throws ServletException {
	}

}
