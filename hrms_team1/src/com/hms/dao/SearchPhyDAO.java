package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.hms.vo.SearchPhyVo;
import com.hms.bo.SearchPhyBo;
import com.hms.vo.PhyDetailVO;
import com.hms.dto.PhyDTO;
public class SearchPhyDAO {
	public static final Logger LOG = Logger.getLogger("SearchPhyDAO.class");
	PhyDTO pdto=new PhyDTO();
	PhyDetailVO pvo;//=new PhyDetailVO();
	ArrayList<PhyDetailVO> al=new ArrayList<PhyDetailVO>();
	public PhyDTO searchPhy(SearchPhyVo avo)
	{
		LOG.info("Inside - method searchPhy in SearchPhyDAO class");
		Connection con=ConnManager.getConnection();
		PreparedStatement preparedStatement;
		try
		{
			String sql="select phyid,firstname,lastname,deptid,qualification,experience,state," +
					"plan from physician_data where state=? and plan=? and deptid=? ";
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1,avo.getState());
			preparedStatement.setString(2,avo.getPlan());
			preparedStatement.setString(3,avo.getDept());
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				pvo=new PhyDetailVO();
				pvo.setPhyId(rs.getString(1));
				pvo.setFirstName(rs.getString(2));
				pvo.setLastName(rs.getString(3));
				pvo.setDeptId(rs.getString(4));
				pvo.setQualification(rs.getString(5));
				pvo.setExperience(rs.getDouble(6));
				pvo.setState(rs.getString(7));
				pvo.setPlan(rs.getString(8));
				al.add(pvo);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pdto.setPal(al);
		LOG.info("Existing - method searchPhy in SearchPhyDAO class");
		return pdto;
	}
	/* public static void main(String[] args) {
		
		SearchPhyVo svo1=new SearchPhyVo();
		svo1.setDept("D001");
		svo1.setPlan("Plan A");
		svo1.setState("AL");
		SearchPhyDAO adao=new SearchPhyDAO();
		PhyDTO pd=adao.insert(svo1);
		ArrayList<PhyDetailVO> al1=pd.getPal();
		for (PhyDetailVO phyDetailVO : al1) {
			System.out.print(phyDetailVO.getPhyId()+" ");
			System.out.print(phyDetailVO.getFirstName()+" ");
			System.out.print(phyDetailVO.getLastName()+" ");
			System.out.print(phyDetailVO.getDeptId()+" ");
			System.out.print(phyDetailVO.getQualification()+" ");
			System.out.print(phyDetailVO.getExperience()+" ");
			System.out.print(phyDetailVO.getPlan()+" ");
			System.out.print(phyDetailVO.getState()+ " ");
			System.out.println();
			
		
		} 
	}*/
}
