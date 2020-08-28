package www.maxinhai.com.diaryfx.service;

import www.maxinhai.com.diaryfx.entity.Diary;
import java.util.List;
import java.util.Map;

public interface DiaryService {

    Map<String, Object> findAllDiary(Map<String, Object> params) throws Exception;

    Diary findOneById(Long id) throws Exception;

    int addDiary(Diary diary) throws Exception;

    int modifyDiary(Diary diary) throws Exception;

    int deleteDiary(Long id) throws Exception;

    int batchInsertDiary(List<Diary> diaryList) throws Exception;

}
