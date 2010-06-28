/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.commerce4j.model.dao;

import com.commerce4j.model.dto.HelpDTO;
import java.util.List;

/**
 *
 * @author root
 */
public interface HelpDAO {
/**
 * Find all FAQs
 * @return All question objects
 */
     public List<HelpDTO> findAllFaqs();
}
