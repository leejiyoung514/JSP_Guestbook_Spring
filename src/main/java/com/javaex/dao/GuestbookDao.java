package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
    //삽입기능
	public int insert(GuestbookVo vo) {
		int count=sqlSession.insert("guestbook.insert", vo);
		return count;
	}

	//방명록 글 가져오기
	public List<GuestbookVo> getlist() {
		return sqlSession.selectList("guestbook.list");
	}

	//글 삭제하기
	public int delete(Map<String, Object> map) {
		int count=sqlSession.delete("guestbook.delete", map);
		return count;
	}
}
