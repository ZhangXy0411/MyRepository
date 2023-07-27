package mapper;

import pojo.Clazz;

public interface CLazzMapper {
    /**
     * 分布查询第二步，根据cid获取班级信息
     * @param cid
     * @return
     */
    Clazz selectByIdStep2(Integer cid);

    /**
     * 根据班级编号查询班级信息
     * @param cid
     * @return
     */
    Clazz selectById(Integer cid);

    /**
     * 分布查询，第一步，根据班级id获取班级信息
     * @param cid
     * @return
     */
    Clazz selectByStep1(Integer cid);
}
