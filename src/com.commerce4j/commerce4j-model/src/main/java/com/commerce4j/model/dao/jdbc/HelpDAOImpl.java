/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.commerce4j.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.commerce4j.model.dao.HelpDAO;
import com.commerce4j.model.dto.HelpDTO;

/**
 *
 * @author Ignatiues charles Arun
 */
public class HelpDAOImpl extends JdbcDaoSupport implements HelpDAO
	{

		private RowMapper rowMapper;

		private JdbcTemplate jdbcTemplate;

		/**
		 * Constructor, Creates a new type instance of {@link HelpDAOImpl}.
		 */
		public HelpDAOImpl()
			{
				super();
				rowMapper = new HelpMapper();
			}

		public HelpDAOImpl(JdbcTemplate jdbcTemplate)
			{
				super();
				rowMapper = new HelpMapper();
				this.jdbcTemplate = jdbcTemplate;
			}

		public boolean insertHelp(long question_id, String question,
				String question_desc)
			{
				boolean status = false;
				String sql = "INSERT INTO c4j_help(question_id,question,description) VALUES(?,?,?)";
				try
					{
						Object[] args = new Object[] { question_id, question,
								question_desc };
						int updateStaus = jdbcTemplate.update(sql, args);
						status = (updateStaus == 1 ? true : false);
					} catch (Exception e1)
					{
						e1.printStackTrace();
					}
				return status;
			}

		public HelpDTO findById(Integer questionId)
			{

				String sql = "SELECT question_id, question, description"
						+ " FROM c4j_help WHERE question_id = ?";

				// return (HelpDTO) getJdbcTemplate().queryForObject(sql,
				// new Object[] { questionId }, rowMapper);
				//
				return (HelpDTO) jdbcTemplate.queryForObject(sql,
						new Object[] { questionId }, rowMapper);
			}

		/*
		 * (non-Javadoc)
		 *
		 * @see com.commerce4j.model.dao.HelpDAO#findAllFaqs()
		 */

		public List<HelpDTO> findAllFaqs()
			{
				String sql;

				sql = "SELECT * FROM c4j_help ORDER BY QUESTION_ID";

				List<HelpDTO> list_Help = getJdbcTemplate().query(sql,
						rowMapper);
				return list_Help;

			}

		/**
		 * Entity Row Mapper
		 */
		class HelpMapper implements RowMapper
			{

				/*
				 * (non-Javadoc)
				 *
				 * @see
				 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet
				 * , int)
				 */
				public Object mapRow(ResultSet rs, int rowNum)
						throws SQLException
					{
						HelpDTO help = new HelpDTO();
						help.setQuestion_id(rs.getInt("question_id"));
						help.setQuestion(rs.getString("question"));
						help.setQuestion_description(rs
								.getString("description"));
						return help;
					}
			}

	}
