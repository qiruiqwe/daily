package admin.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import admin.po.Diary;
import admin.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping("/diaryList")
	public ModelAndView diaryList() throws Exception {

		List<Diary> diaryList = diaryService.showDiaryList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("diaryList", diaryList);
		modelAndView.setViewName("index");
		return modelAndView;

	}
	
	@RequestMapping("/diaryList2")
	public ModelAndView diaryList2() throws Exception {

		List<Diary> diaryList = diaryService.showDiaryList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("diaryList", diaryList);
		modelAndView.setViewName("DiaryList");
		return modelAndView;

	}
	
	@RequestMapping("/showDiary")
	public ModelAndView showDiary(Integer id) throws Exception {
		Diary diary = diaryService.findDiaryByid(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("diary", diary);
		modelAndView.setViewName("editDiary");
		return modelAndView;
	}
	
	@RequestMapping("/searchDiary")
	public ModelAndView search(String search) throws Exception {
		List<Diary> diaryList = diaryService.search(search);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("diaryList", diaryList);
		modelAndView.setViewName("searchResult");
		return modelAndView;
	}

	@RequestMapping("/editDiary")
	public ModelAndView editDiary(Diary diary) throws Exception {
		diaryService.editDiary(diary);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping("/deleteDiary")
	public ModelAndView deleteDiary(Integer id) throws Exception {
		diaryService.deleteDiaryByid(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping("/showView")
	public ModelAndView showView() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insertDiary");
		return modelAndView;
	}
	
//	@RequestMapping("/insertDiary")
//	public ModelAndView insertdiary(Diary diary) throws Exception {
//		diaryService.insertDiary(diary);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("success");
//		return modelAndView;
//	}
	
	@RequestMapping("/insertDiary")
	public ModelAndView insertDiary(MultipartFile pic,String createtime,String title,String content) throws Exception {
		Diary diary=new Diary();
		//原始名称
		String originalFilename =pic.getOriginalFilename();
		//上传图片
		if(pic!=null && originalFilename!=null && originalFilename.length()>0){
			
			//存储图片的物理路径
			String pic_path = "G:\\eclipse-jee-neon-2-win32-x86_64\\eclipse\\JAVA-EEworkspace\\upload\\temp\\";
			
			
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+newFileName);
			
			//将内存中的数据写入磁盘
			pic.transferTo(newFile);
			
			//将新图片名称写到diary中
			diary.setPic(newFileName);
		}
		diary.setCreatetime(createtime);
		diary.setTitle(title);
		diary.setContent(content);
		diaryService.insertDiary(diary);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;

}
	
	@RequestMapping("/insertDiarytest")
	public ModelAndView insertDiarytest(Diary diary,MultipartFile pic) throws Exception {
		//原始名称
		String originalFilename =pic.getOriginalFilename();
		//上传图片
		if(pic!=null && originalFilename!=null && originalFilename.length()>0){
			
			//存储图片的物理路径
			String pic_path = "G:\\eclipse-jee-neon-2-win32-x86_64\\eclipse\\JAVA-EEworkspace\\upload\\temp";
			
			
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+newFileName);
			
			//将内存中的数据写入磁盘
			pic.transferTo(newFile);
			
			//将新图片名称写到diary中
			diary.setPic(newFileName);
			
		}
		diaryService.insertDiary(diary);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}

}
