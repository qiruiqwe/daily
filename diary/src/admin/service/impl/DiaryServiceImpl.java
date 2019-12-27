package admin.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import admin.mapper.DiaryMapper;
import admin.po.Diary;
import admin.service.DiaryService;

public class DiaryServiceImpl implements DiaryService{
	@Autowired
	private DiaryMapper diaryMapper;
	
	
	
	@Override
	public List<Diary> showDiaryList() throws Exception {
		
		return diaryMapper.showDiaryList();
	}



	@Override
	public Diary findDiaryByid(Integer id) throws Exception {
		
		return diaryMapper.findDiaryByid(id);
	}
	
	@Override
	public List<Diary> search(String search) throws Exception {
		
		return diaryMapper.search(search);
	}


	@Override
	public void editDiary(Diary diary) throws Exception {
		diaryMapper.editDiary(diary);
		
	}

	@Override
	public void deleteDiaryByid(Integer id) throws Exception {
		diaryMapper.deleteDiaryByid(id);
		
	}
	
	@Override
	public void insertDiary(Diary diary) throws Exception {
		diaryMapper.insertDiary(diary);
		
	}
}
