package www.maxinhai.com.diaryfx.entity;

import lombok.Data;

/**
 * 类描述: 日记实体类
 * @Author: 15735400536
 * @Date: 2020/8/28 16:48
 */
@Data
public class Diary extends BaseEntity {

    private Long id;

    private String title;

    private String content;

    private String author_id;

    private String author;

}
