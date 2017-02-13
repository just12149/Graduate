package graduate.service.impl;


import graduate.dao.CodeDao;
import graduate.model.CodeInfo;
import graduate.service.CodeService;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl  implements CodeService {

    CodeDao codeDao;
    /**
     * 新增code
     * @param code
     */
    @Override
    public void saveCode(CodeInfo code) {

        codeDao.insertCodeInfo(code);

    }
    /**
     * 编辑code
     * @param code
     */
    @Override
    public void updateCode(CodeInfo code) {
        codeDao.updateCodeInfo(code);

    }
    /**
     * 删除code
     * @param codeId
     */
    @Override
    public void removeCode(Integer codeId) {

        codeDao.deleteCodeInfo(codeId);

    }

    /**
     * 根据codeId查询code
     * @param codeId
     * @return
     */
    @Override
    public CodeInfo findCodeByCodeId(Integer codeId) {
        CodeInfo codeInfo= codeDao.selectCodeByCodeId(codeId);

        return codeInfo;
    }


}
