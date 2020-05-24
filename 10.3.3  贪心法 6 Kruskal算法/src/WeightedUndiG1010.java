//ϰ7  ����ͼ10.10��ʾ��Ȩ����ͼ����С�����������·����
 
public class WeightedUndiG1010
{
    public static void main(String args[])
    {
        String[] vertices={"A","B","C","D","E","F"};           //��Ȩ����ͼ�Ķ��㼯��
        Edge edges[]={new Edge(0,1,16),new Edge(0,2,18),new Edge(0,3,5), //�߼���
                      new Edge(1,0,16),new Edge(1,2,7),new Edge(1,4,3),
                      new Edge(2,0,18),new Edge(2,1,7),new Edge(2,3,15),new Edge(2,4,26),new Edge(2,5,4),
                      new Edge(3,0,5),new Edge(3,2,15),new Edge(3,5,8), 
                      new Edge(4,1,3),new Edge(4,2,26),new Edge(4,5,6),
                      new Edge(5,2,4), new Edge(5,3,8),new Edge(5,4,6)};
//        AdjMatrixGraph<String> graph = new AdjMatrixGraph<String>(vertices, edges);
        AdjListGraph<String> graph = new AdjListGraph<String>(vertices, edges);
//        System.out.println("��Ȩ����ͼ��"+graph.toString());
//        graph.minSpanTree_prim();                          //�����Ȩͼ��С������������ķ�㷨
        graph.shortestPath(0);               //����A�ĵ�Դ���·����Dijkstra�㷨
//        for (int i=0; i<graph.vertexCount(); i++)
//            graph.shortestPath(i);               //����vi�ĵ�Դ���·����Dijkstra�㷨

    }
}
/*
�������н�����£�
//Prim
mst���飺(0,1,16)(0,2,17)(0,3,5)(0,4,99999)(0,5,99999)
mst���飺(0,3,5)(3,2,15)(0,1,16)(0,4,99999)(3,5,8)
mst���飺(0,3,5)(3,5,8)(0,1,16)(5,4,6)(5,2,4)
mst���飺(0,3,5)(3,5,8)(5,2,4)(5,4,6)(2,1,7)
mst���飺(0,3,5)(3,5,8)(5,2,4)(5,4,6)(4,1,3)
mst���飺(0,3,5)(3,5,8)(5,2,4)(5,4,6)(4,1,3)
��С�������ı߼��ϣ�(0,3,5) (3,5,8) (5,2,4) (5,4,6) (4,1,3) ����С����Ϊ26

//D

vset����{1,0,0,0,0,0}	path����{-1,0,0,0,-1,-1}	dist����{0,16,18,5,��,��}
vset����{1,0,0,1,0,0}	path����{-1,0,0,0,-1,3}	dist����{0,16,18,5,��,13}
vset����{1,0,0,1,0,1}	path����{-1,0,5,0,5,3}	dist����{0,16,17,5,19,13}
vset����{1,1,0,1,0,1}	path����{-1,0,5,0,5,3}	dist����{0,16,17,5,19,13}
vset����{1,1,1,1,0,1}	path����{-1,0,5,0,5,3}	dist����{0,16,17,5,19,13}
vset����{1,1,1,1,1,1}	path����{-1,0,5,0,5,3}	dist����{0,16,17,5,19,13}
�Ӷ���A��������������·�����£�
(A,B)����Ϊ 16
(A,D,F,C)����Ϊ 17
(A,D)����Ϊ 5
(A,D,F,E)����Ϊ 19
(A,D,F)����Ϊ 13

*/

/*
�������н�����£�

*/        
/*
*/ 

