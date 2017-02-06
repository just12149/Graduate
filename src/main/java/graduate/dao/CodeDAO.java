package graduate.dao;

import graduate.model.CodeInfo;
import org.apache.ibatis.annotations.Param;


/**
 * Created by ${niuting} on 2017/1/13.
 */
public interface CodeDAO {

    //public List<User>query(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd);

    public void insertCodeInfo(@Param("code") CodeInfo codeInfo);

    public void updateCodeInfo(@Param("code") CodeInfo codeInfo);

    public void deleteCodeInfo(@Param("codeId") Integer codeId);

    public CodeInfo selectCodeByCodeId(@Param("codeId") Integer codeId);


}
