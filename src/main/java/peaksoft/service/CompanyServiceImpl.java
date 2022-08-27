package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.CompanyDao;
import peaksoft.entity.Company;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Override
    public void addCompany(Company company) {
    companyDao.addCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public void updateCompany(Company company) {
    companyDao.updateCompany(company);
    }

    @Override
    public void deleteCompany(Company company) {
        companyDao.deleteCompany(company);
    }
}
