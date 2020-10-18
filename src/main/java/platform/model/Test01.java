package platform.model;

import tester.model.testBean;

public class Test01 {

	public static void main(String[] args) {
		TestBean testBean = new TestBean();
		testBean.id = 123;
		testBean.name = "一二三";
		System.out.println(testBean.id);
		System.out.println(testBean.name);

	}

	{
		AllsubjectBean allsubjectbean = new AllsubjectBean();
		allsubjectbean.subject = "分類";
		allsubjectbean.time = "時間";
		allsubjectbean.username = "姓名";
		allsubjectbean.lasttime = "最後時間";
		allsubjectbean.colum = 2;
		System.out.println(allsubjectbean.subject);
		System.out.println(allsubjectbean.time);
		System.out.println(allsubjectbean.username);
		System.out.println(allsubjectbean.lasttime);
		System.out.println(allsubjectbean.colum);
	}
	{
		GroupBean groupbean = new GroupBean();
		groupbean.subject = "分類";
		groupbean.time = "時間";
		groupbean.username = "姓名";
		groupbean.lasttime = "最後時間";
		groupbean.colum_5 = 2;
		System.out.println(groupbean.subject);
		System.out.println(groupbean.time);
		System.out.println(groupbean.username);
		System.out.println(groupbean.lasttime);
		System.out.println(groupbean.colum_5);
	}
	{
		KnowledgeBean knowledgebean = new KnowledgeBean();
		knowledgebean.subject = "分類";
		knowledgebean.time = "時間";
		knowledgebean.username = "姓名";
		knowledgebean.lasttime = "最後時間";
		knowledgebean.colum_5_1 = 2;
		System.out.println(knowledgebean.subject);
		System.out.println(knowledgebean.time);
		System.out.println(knowledgebean.username);
		System.out.println(knowledgebean.lasttime);
		System.out.println(knowledgebean.colum_5_1);
	}
	{
		LostBean lostbean = new LostBean();
		lostbean.subject = "分類";
		lostbean.time = "時間";
		lostbean.username = "姓名";
		lostbean.lasttime = "最後時間";
		lostbean.colum_5_3 = 2;
		System.out.println(lostbean.subject);
		System.out.println(lostbean.time);
		System.out.println(lostbean.username);
		System.out.println(lostbean.lasttime);
		System.out.println(lostbean.colum_5_3);
	}
	{
		QuestionBean questionbean = new QuestionBean();
		questionbean.subject = "分類";
		questionbean.time = "時間";
		questionbean.username = "姓名";
		questionbean.lasttime = "最後時間";
		questionbean.colum_5_4 = 2;
		System.out.println(questionbean.subject);
		System.out.println(questionbean.time);
		System.out.println(questionbean.username);
		System.out.println(questionbean.lasttime);
		System.out.println(questionbean.colum_5_4);
	}
}
