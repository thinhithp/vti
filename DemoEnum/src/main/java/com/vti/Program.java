package com.vti;

import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class Program {
	public static void main(String[] args) {

		GroupRepository groupRepository = new GroupRepository();

	/*System.out.println("***********GET ALL USERS***********");

		List<Group> group = groupRepository.getAllGroup();
		for(Group grouplist : group){
			System.out.println(grouplist.toString());
		}
		System.out.println("");*/


		System.out.println("***********CREATE GROUP***********");
		Group createGoup = groupRepository.createGroup(new Group("Tesew345345ewe1234ssss"));
		System.out.println(createGoup);


		/*System.out.println("***********GET GROUP BY ID***********");
		Group group2 = groupRepository.getGroupById((short) 2);
		System.out.println(group2);

		System.out.println("***********GET GROUP BY NAME***********");
		Group group1 = groupRepository.getGroupByName("Testing System");
		System.out.println(group1);*/

		/*System.out.println("***********UPDATE OR DELETE GROUP***********");
		groupRepository.updateAndDeleteGroup((short) 1,"Tests");*/
	}


}







