/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.commerce4j.model.dao.jdbc;

import com.commerce4j.model.dao.HelpDAO;
import com.commerce4j.model.dto.HelpDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author Ignatiues charles Arun
 */
public class HelpDAOImpl extends JdbcDaoSupport implements HelpDAO {

    private RowMapper rowMapper;

    /**
	 * Constructor, Creates a new type instance of {@link HelpDAOImpl}.
     */
    public HelpDAOImpl()
    {
        super();
        rowMapper = new HelpMapper();
    }

    /* (non-Javadoc)
	 * @see com.commerce4j.model.dao.HelpDAO#findAllFaqs()
	 */

    public List<HelpDTO> findAllFaqs() {
        String sql;

        sql = "SELECT * FROM c4j_help ORDER BY QUESTION_ID";

        List<HelpDTO> list_Help = getJdbcTemplate().query(sql, rowMapper);
        return list_Help;

    }
/**
 * Entity Row Mapper
 */
    class HelpMapper implements RowMapper
    {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
            HelpDTO help = new HelpDTO();
            help.setQuestion_id(rs.getInt("question_id"));
            help.setQuestion(rs.getString("question"));
            help.setQuestion_description(rs.getString("description"));
            return help;
        }
    }


}
