package www.maxinhai.com.diaryfx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.maxinhai.com.diaryfx.entity.Diary;
import www.maxinhai.com.diaryfx.mapper.DiaryMapper;
import www.maxinhai.com.diaryfx.service.DiaryService;
import www.maxinhai.com.diaryfx.util.AssertUtils;
import www.maxinhai.com.diaryfx.util.EmptyUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: 日记业务层
 * @Author: 15735400536
 * @Date: 2020/8/28 16:53
 */
@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    /**
     * 根据id查询日记数据
     * @param id
     * @return
     * @throws Exception
     */
    private Diary getDiaryById(Long id) throws Exception {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(id), "缺少必要参数!");
        Diary selectResult = diaryMapper.findOneDiaryById(id);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(selectResult), "数据不存在!");
        return selectResult;
    }

    @Override
    public Map<String, Object> findAllDiary(Map<String, Object> params) throws Exception {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params), "缺少必要参数!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params.get("pageNum")), "pageNum不为空!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params.get("pageSize")), "pageSize不为空!");
        Integer pageNum = Integer.valueOf(String.valueOf(params.get("pageNum")));
        Integer pageSize = Integer.valueOf(String.valueOf(params.get("pageSize")));
        if(pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        if(pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Diary> diaryList = diaryMapper.findAllByCondition(params);
        PageInfo<Diary> pageInfo = new PageInfo<>(diaryList);
        Map<String, Object> result = new HashMap<>();
        result.put("message", "success");
        result.put("code", 200);
        result.put("data", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @Override
    public Diary findOneById(Long id) throws Exception {
        return getDiaryById(id);
    }

    @Override
    public int addDiary(Diary diary) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(diary.getTitle()), "标题不为空!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(diary.getAuthor_id()), "作者id不为空!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(diary.getAuthor()), "作者不为空!");
        Map<String, Object> params = new HashMap<>();
        params.put("title", diary.getTitle());
        params.put("author", diary.getAuthor());
        params.put("author_id", diary.getAuthor_id());
        Diary findResult = diaryMapper.findOneByCondition(params);
        AssertUtils.assertFalse(EmptyUtils.isEmpty(findResult), "标题已存在!");
        diary.setCreateTime(new Date());
        return diaryMapper.addDiary(diary);
    }

    @Override
    public int modifyDiary(Diary diary) throws Exception {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(diary), "缺少必要参数!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(diary.getId()), "缺少必要参数!");
        Diary findResult = getDiaryById(diary.getId());
        AssertUtils.assertTrue(EmptyUtils.isEmpty(findResult), "数据不存在!");
        diary.setModifyTime(new Date());
        return diaryMapper.updateDiaryById(diary);
    }

    @Override
    public int deleteDiary(Long id) throws Exception {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(id), "缺少必要参数!");
        return diaryMapper.deleteDiaryById(id);
    }

    @Override
    public int batchInsertDiary(List<Diary> diaryList) throws Exception {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(diaryList), "缺少必要参数!");
        return diaryMapper.batchInsertDiary(diaryList);
    }

}
