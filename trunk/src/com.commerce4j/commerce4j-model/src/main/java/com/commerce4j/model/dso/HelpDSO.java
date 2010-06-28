/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.commerce4j.model.dso;

import com.commerce4j.model.dto.HelpDTO;
import java.util.List;

/**
 *
 * @author Ignatiues charles Arun
 */
public interface HelpDSO {
    public List<HelpDTO> findAllFaqs();

}
