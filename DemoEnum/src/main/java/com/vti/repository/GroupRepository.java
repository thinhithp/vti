package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;


public class GroupRepository {
    private HibernateUtils hibernateUtils;

    public GroupRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Group> getAllGroup() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Group> query = session.createQuery("FROM Group");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public Group createGroup(Group group) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(group);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return group;
    }

    public Group getGroupById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Group group = session.get(Group.class, id);
            return group;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public Group getGroupByName(String name){
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Group> groupQuery = session.createQuery("FROM Group WHERE name = :nameParameter ");

            groupQuery.setParameter("nameParameter",name);
            Group group = groupQuery.uniqueResult();
            return group;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void updateAndDeleteGroup(Short id, String name){
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Group group = session.load(Group.class,id);
            group.setName(name);
            session.getTransaction().commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public boolean isGroupExistsById(short id){
        Group group = getGroupById(id);
        if (group == null){
            return false;
        }
        return true;
    }
    public boolean isGroupExistsByName(String name){
        Group group = getGroupByName(name);
        if (group == null){
            return false;
        }
        return true;
    }
}
