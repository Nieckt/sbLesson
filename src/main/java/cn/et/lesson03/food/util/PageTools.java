package cn.et.lesson03.food.util;

import java.util.List;

public class PageTools {
	/**
	 * �������
	 * @param curPage ҳ�洫��ĵ�ǰҳ
	 * @param totalCount ��ݿ��ѯ���ܼ�¼��
	 * @param pageCount	ÿҳ��ʾ������
	 */
	public PageTools(Integer curPage,Integer totalCount,Integer pageCount) {
		//��ǰҳ
		this.curPage=curPage;
		//System.out.println("��ǰҳ��"+curPage);
		this.total=totalCount;
		this.pageCount=pageCount==null?this.pageCount:pageCount;
		//System.out.println("��ǰ��ʾ������"+pageCount);
		//��һҳ
		this.prePage=(curPage==1?1:curPage-1);
		//���ҳ
		this.totalPage = (totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1);
		//��һҳ
		this.nextPage=(curPage==totalPage?totalPage:curPage+1);
		//System.out.println("���һҳ��"+totalPage);
		//��ʼ����
		this.startIndex=(curPage-1)*this.pageCount+1;
		//��������
		this.endIndex=curPage*this.pageCount;
	}
	/**
	 * ��ǰҳ����̬�� ��ҳ�洫�ݵģ�
	 */
	private Integer curPage;
	/**
	 * ÿҳ��ʾ������
	 * Ĭ��ÿҳ��ʾ10��
	 */
	private Integer pageCount=10;
	/**
	 * ��һҳ
	 * prePage = (curPage==1?1:curPage-1);
	 * 
	 * ���� 
	 * 	��һҳ		��ǰҳ 		��һҳ
	 * 	  1		  1		 2
	 * 	  1		  2	     3
	 * 
	 */
	private Integer prePage;
	/**
	 * ��һҳ
	 * next����һ��
	 * ���ǰҳ�������һҳ����һҳ���ǵ�ǰҳ+1����������    
	 * nextPage = (curPage==totalPage?totalPage:curPage+1)
	 * 
	 */
	private Integer nextPage;
	/**
	 * ��ҳ��
	 * total:ȫ������˼
	 * pageCount(ÿҳ��ʾ������)	totalCount���ܼ�¼��  totalPage����ҳ��
	 * 			10				20				2
	 * 			10				21				3
	 * 
	 * totalPage = (totalCount%pageCount==0?totalCount/pageCount:totalCount/pageCount+1)
	 * 
	 */
	private Integer totalPage;
	/**
	 * �ܼ�¼�����ݿ��ѯ�����ģ�
	 */
	private Integer total;
	/**
	 * ��ʼ����
	 * curPage pageCount start-end
	 * 	  1		   10      1-10
	 *    2        10 	   11-21
	 *    				(curPage-1)*pageCount+1;
	 */
	private Integer startIndex;
	/**
	 * ��������
	 */
	private Integer endIndex;
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	/**
	 * �洢���ղ�ѯ�����
	 */
	private List rows;
	
	
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	public static void main(String[] args) {
		/**
		 * ����ݿ���ȡ�����
		 * 
		 */
		int curPage = 2;
		int total = 26;
		int pageCount = 5;
		PageTools pt = new PageTools(curPage, total, pageCount);
		//��һҳ
		System.out.println("��һҳ��"+pt.getPrePage());
		//��һҳ
		System.out.println("��һҳ��"+pt.getNextPage());
		//��ҳ��
		System.out.println("��ҳ��"+pt.getTotalPage());
		//��ʼ����
		System.out.println("��ʼ����"+pt.getStartIndex());
		//��������
		System.out.println("��������"+pt.getEndIndex());
		//System.out.println("�ܼ�¼��:"+totalCount);
	}
	
}
