package graduate.service;

import graduate.model.CodeInfo;

/**
 * Created by ${niuting} on 2017/1/13.
 */
public interface CodeService {
    /**
     * 新增
     * @param codeInfo
     */
    void saveCode(CodeInfo codeInfo);

    /**修改
     *
     * @param codeInfo
     */
    void updateCode(CodeInfo codeInfo);

    /**
     * 删除
     * @param codeId
     */

    void removeCode(Integer codeId);

    /**
     * 根据codeId查询
     * @param codeId
     * @return
     */

    CodeInfo findCodeByCodeId(Integer codeId);
}
