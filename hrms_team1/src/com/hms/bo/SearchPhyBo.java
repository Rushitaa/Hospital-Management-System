package com.hms.bo;
import com.hms.vo.SearchPhyVo;
import com.hms.bo.SearchPhyBo;
import com.hms.dto.PhyDTO;
import org.apache.log4j.Logger;
import com.hms.dao.SearchPhyDAO;


public class SearchPhyBo {
	public static final Logger LOG = Logger.getLogger("SearchPhyBo.class");
	SearchPhyDAO adao=new SearchPhyDAO();
	PhyDTO albo=new PhyDTO();
public PhyDTO validate(SearchPhyVo svo)
{
	LOG.info("Inside - method validate in SearchPhyBo class");
	albo=adao.searchPhy(svo);
	LOG.info("Existing - method validate in SearchPhyBo class");
	return albo;
}
}
