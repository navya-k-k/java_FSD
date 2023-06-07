package com.ecommerce.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.ecommerce.entity.Eproduct;   

public class EProductDAO {

        JdbcTemplate template;    
            
        public void setTemplate(JdbcTemplate template) {    
            this.template = template;    
        }    
        
        public List<Eproduct> getProducts(){    
            return template.query("select * from eproduct",new RowMapper<Eproduct>(){    
                public Eproduct mapRow(ResultSet rs, int row) throws SQLException {    
                        Eproduct e=new Eproduct();    
                    e.setId(rs.getInt(1));    
                    e.setName(rs.getString(2));    
                    e.setPrice(rs.getBigDecimal(3));    
                    e.setDateAdded(rs.getDate(4));    
                    return e;    
                }    
            });    
        }    
}


