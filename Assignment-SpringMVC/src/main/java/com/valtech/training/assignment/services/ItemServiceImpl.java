package com.valtech.training.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignment.entities.Item;
import com.valtech.training.assignment.repos.ItemRepo;
import com.valtech.training.assignment.vos.ItemVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public ItemVO save(ItemVO itemVO) {
		return ItemVO.from(itemRepo.save(itemVO.to()));
	}

	@Override
	public ItemVO update(ItemVO itemVO) {
		return ItemVO.from(itemRepo.save(itemVO.to()));
	}

	@Override
	public void delete(Item i) {
		itemRepo.delete(i);

	}

	@Override
	public ItemVO getItem(int id) {
		return ItemVO.from(itemRepo.getReferenceById(id));
	}

	@Override
	public List<ItemVO> getAll() {
		return ItemVO.from(itemRepo.findAll());
	}

}
