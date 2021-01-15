package com.xjforum.home.service;

import com.xjforum.home.entity.City;
import com.xjforum.home.dao.CityDao;
import com.xjforum.home.entity.CityParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CityServiceImpl {
    @Autowired
    private CityDao cityDao;

    /**
     * @param cityName
     * @return
     */
    public City findByCityName(String cityName){
        City city = cityDao.findByName(cityName);
        return city;
    }

    /**
     * @param id
     * @return
     */
    public List<City> queryCityList(int id){
        List<City> list = cityDao.queryCityList(id);
        if (list!=null) {
            return list;
        }
        else {
            return null;
        }
    }

    /**
     * @param page
     * @param size
     * @return
     */
    public Page<City> findAlllist(int page ,int size){
        Pageable pageable = PageRequest.of(page-1,size);
        Page<City> list = cityDao.findAlllist(pageable);
        return list;
    }

    /**
     * @param city
     * @return
     */
    public String save(City city){
        City city1 = cityDao.findByName(city.getName());
        if (city1!=null){
            return "已经存在";
        }else {
            cityDao.save(city);
            return "保存成功";
        }
    }

    /**
     * @param city
     * @return
     */
    public String delete(City city) {
        if (cityDao.findByName(city.getName()) != null) {
            int i = cityDao.deleteByCountryCode(city.getName());
            if (i == 1) {
                return "删除成功";
            } else {
                return "删除失败";
            }
        }
        return "不存在";
    }

    /**
     * @param city
     * @return
     */
    public String updateCity(City city){
        City city1 = cityDao.findByName(city.getName());
        if (city1!=null){
            city.setID(city1.getID());
            cityDao.save(city);
            return "修改成功";
        }else {
            return "不存在";
        }
    }

    /**动态条件查询
     * @param page
     * @param size
     * @param cityParam
     * @return
     */
    public Page<City> findAllByKeyWord(int page , int size, CityParam cityParam){
        //重写toPredicate方法实现动态条件查询
        Specification<City> specification = new Specification<City>() {
            @Override
            public Predicate toPredicate(Root<City> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(!"".equals(cityParam.getName())){
                   // System.out.println(cityParam.getName());
                    predicates.add(criteriaBuilder.equal(root.get("Name"), cityParam.getName()));
                }
                if(!"".equals(cityParam.getCountryCode())){
                   // System.out.println(cityParam.getCountryCode());
                    predicates.add(criteriaBuilder.equal(root.get("CountryCode"), cityParam.getCountryCode()));
                }
                if(!"".equals(cityParam.getDistrict())){
                   // System.out.println(cityParam.getDistrict());
                    predicates.add(criteriaBuilder.equal(root.get("District"), cityParam.getDistrict()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

            }

        };
        Pageable pageable = PageRequest.of(page-1,size);
        Page<City> all = cityDao.findAll(specification, pageable);
        return all;
    }

    public int deleteBatch(List<String> names){
        int result = cityDao.deleteBatch(names);
        return result;
    }
}
