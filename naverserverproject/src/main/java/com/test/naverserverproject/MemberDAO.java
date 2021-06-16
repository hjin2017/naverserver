package com.test.naverserverproject;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("meberdao")
public interface MemberDAO {
	public MemberVO getOneMember(String st_id);
	public List<MemberVO> getAllMember();
	public MemberVO getPagingMember(int[] num);
	public MemberVO checkMember (MemberVO vo);
	public void insertMember (MemberVO vo);
	public String getNameMember(String st_name);
}