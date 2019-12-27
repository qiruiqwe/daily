package admin.mapper;

import java.util.List;

import admin.po.Diary;

public interface DiaryMapper {
	//查询日记列表(所有信息)
	List<Diary> showDiaryList() throws Exception;
	
	//根据ID查找日记
	Diary findDiaryByid(Integer id) throws Exception;
	
	//根据输入条件查找日记
	List<Diary> search(String title) throws Exception;
	
	//修改日记
	void editDiary(Diary diary) throws Exception;
	
	//删除日记
	void deleteDiaryByid(Integer id) throws Exception;
	
	//添加日记
	void insertDiary(Diary diary) throws Exception;
	

}
