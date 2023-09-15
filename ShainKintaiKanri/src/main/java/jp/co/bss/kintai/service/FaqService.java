/**
 * 
 */
package jp.co.bss.kintai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.bss.kintai.dao.FaqInfo;
import jp.co.bss.kintai.mapper.FaqInfoMapper;

@Service
public class FaqService {
	@Autowired
	private FaqInfoMapper faqInfoMapper;

	public FaqInfo getFaqInfo(String userNm) {
		FaqInfo data = faqInfoMapper.getFaqInfoByUserName(userNm);

		if (data == null) {
			insertFAQ(userNm);
			data = faqInfoMapper.getFaqInfoByUserName(userNm);
		}

		return data;
	}
	
	public List<FaqInfo> getFaqInfoList() {
		List<FaqInfo> data = faqInfoMapper.getFaqListInfoByUserName();
		return data;
	}

	@Transactional
	public void insertFAQ(String username) {
		faqInfoMapper.insertFAQ(username);
	}

	@Transactional
	public void updateFAQ(FaqInfo faq) {
		faqInfoMapper.updateFAQ(faq);
	}

}
