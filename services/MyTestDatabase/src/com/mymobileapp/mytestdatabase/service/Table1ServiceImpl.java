/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.mymobileapp.mytestdatabase.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.mymobileapp.mytestdatabase.*;


/**
 * ServiceImpl object for domain model class Table1.
 * @see com.mymobileapp.mytestdatabase.Table1
 */
@Service("MyTestDatabase.Table1Service")
public class Table1ServiceImpl implements Table1Service {


    private static final Logger LOGGER = LoggerFactory.getLogger(Table1ServiceImpl.class);

    @Autowired
    @Qualifier("MyTestDatabase.Table1Dao")
    private WMGenericDao<Table1, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Table1, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "MyTestDatabaseTransactionManager")
     public Page<Table1> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "MyTestDatabaseTransactionManager")
    @Override
    public Table1 create(Table1 table1) {
        LOGGER.debug("Creating a new table1 with information: {}" , table1);
        return this.wmGenericDao.create(table1);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "MyTestDatabaseTransactionManager")
    @Override
    public Table1 delete(Integer table1Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting table1 with id: {}" , table1Id);
        Table1 deleted = this.wmGenericDao.findById(table1Id);
        if (deleted == null) {
            LOGGER.debug("No table1 found with id: {}" , table1Id);
            throw new EntityNotFoundException(String.valueOf(table1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "MyTestDatabaseTransactionManager")
    @Override
    public Page<Table1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all table1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "MyTestDatabaseTransactionManager")
    @Override
    public Page<Table1> findAll(Pageable pageable) {
        LOGGER.debug("Finding all table1s");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "MyTestDatabaseTransactionManager")
    @Override
    public Table1 findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding table1 by id: {}" , id);
        Table1 table1=this.wmGenericDao.findById(id);
        if(table1==null){
            LOGGER.debug("No table1 found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return table1;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "MyTestDatabaseTransactionManager")
    @Override
    public Table1 update(Table1 updated) throws EntityNotFoundException {
        LOGGER.debug("Updating table1 with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "MyTestDatabaseTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


