package com.efacture.dev.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Commission;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.repository.CommissionRepository;
import com.efacture.dev.service.ServiceCommission;
@Service
public class CommissionImpl implements ServiceCommission{
	@Autowired
	private CommissionRepository commissionRepository; 
	
	
	@Override
	public List<Commission> listCommissions() {
		// TODO Auto-generated method stub
		return commissionRepository.findAll();
	}

	@Override
	public Commission modifierCommission(Commission com) {
		com.setDateMaj(new Date(System.currentTimeMillis()));
		Commission commission = commissionRepository.findById(com.getIdCommission()).get();
		if (commission != null) {
			return commissionRepository.save(com);
		}else {
			return new Commission();
		}
	}

	@Override
	public Commission getCommissionParId(Long idCommission) {
		//Commission commission = new Commission();
		return commissionRepository.findById(idCommission).get();
		
	}

	@Override
	public Commission ajouterCommission(Commission com) {
		Commission commission1 = new Commission();
		try {
			if (commissionRepository.findByIdCommission(com.getIdCommission())==null) {
				Commission commission = new Commission(com.getMontantCommission(),com.getTypeCommission(),
						com.getPourCommarch(),com.getPourCombank(),com.getCommissionFacturier(),com.getCommissionBanque(),com.getLibelle(),com.getFacturier(),com.getLoginAdd(),com.getDateAdd(),com.getLoginMaj(),com.getDateMaj());
				commission1=commissionRepository.save(commission);
			}
		} catch (Exception e) {
			return new Commission();
		}
		return commission1;
	}

	@Override
	public List<Commission> rechercheByCommission(String facturier, String libelle) {
		// TODO Auto-generated method stub
		return commissionRepository.FacturierContainingIgnoreCaseAndLibelleContainingIgnoreCase(facturier, libelle);
	}

	@Override
	public List<Commission> rechercheByCommissionfacturier(Long commissionfacturier) {
		// TODO Auto-generated method stub
		return commissionRepository.findByCommissionFacturierContaining(commissionfacturier);
		
	}

	@Override
	public Commission supprimmer(long idCommission) {
		Commission commission = commissionRepository.findByIdCommission(idCommission);
		commissionRepository.deleteById(commission.getIdCommission());
		return new Commission(commission.getIdCommission());
	}

	

	
	

	

}
