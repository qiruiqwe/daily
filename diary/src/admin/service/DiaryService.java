package admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import admin.po.Diary;

public interface DiaryService {
		//查询日记列表(所有信息)
		List<Diary> showDiaryList() throws Exception;
		
		//根据ID查找日记
		public Diary findDiaryByid(Integer id) throws Exception;
		
		//根据输入条件查找日记
		List<Diary> search(String search) throws Exception;
		
		//修改日记
		public void editDiary(Diary diary) throws Exception;
		
		//删除日记
		public void deleteDiaryByid(Integer id) throws Exception;
		
		//添加日记
		public void insertDiary(Diary diary) throws Exception;
		
		
}
