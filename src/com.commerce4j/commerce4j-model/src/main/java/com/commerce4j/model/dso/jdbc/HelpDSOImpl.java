/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.commerce4j.model.dso.jdbc;

import com.commerce4j.model.dao.HelpDAO;
import com.commerce4j.model.dso.HelpDSO;
import com.commerce4j.model.dto.HelpDTO;
import java.util.List;

/**
 *
 * @author Ignatiues charles Arun
 */
public class HelpDSOImpl implements HelpDSO{
    private HelpDAO helpDao;

    public HelpDAO getHelpDao() {
        return helpDao;
    }

    public void setHelpDao(HelpDAO helpDao) {
        this.helpDao = helpDao;
    }


   /* (non-Javadoc)
	 * @see com.commerce4j.model.dso.ItemDSO#findAllFaqs()
	 */

    public List<HelpDTO> findAllFaqs() {
       return  helpDao.findAllFaqs();

    }

}
