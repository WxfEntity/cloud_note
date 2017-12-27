package cn.wxf.note.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by TYZ027 on 2017/12/22.
 */
@Repository
public interface BlogDao {
    List<Map<String,Object>> findBlogBytime(@Param("userId")String userId, @Param("start")int start,
                                            @Param("pageSize")int pageSize);
    Integer blogNum(String userId);

}
