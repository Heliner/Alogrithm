#include<stdio.h>
#include<string.h>
#define INF 0x3f3f3f3;//找一个较大的数表示路口之间没路
int map[110][110],dis[110],visited[110];
void Dijkstra(int n,int x)
{
 int i,p,j,min;
 for (i=1;i<=n;i++)
 {
  dis[i]=map[1][i];//从1路口到各路口的距离
  visited[i]=0;//表示未被标记
 }
 visited[x]=1;//将一号标记
 for (i=1;i<=n;i++)
 {
  min=INF;
  for (j=1;j<=n;j++)//找出离1路口最短的路口
  {
   if(!visited[j] && dis[j]<min)
   {
    p=j;
    min=dis[j];
   }
  }
  visited[p]=1;
  for (j=1;j<=n;j++)//更新离1路口最近的距离
  {
   if(!visited[j] && dis[p]+map[p][j]<dis[j])
   {
     dis[j]=dis[p]+map[p][j];
   }
  }
 }
}
int main()
{
 int n,m,i,j,a,b,c;
 while(scanf("%d%d",&n,&m)!=EOF,n+m)
 {
  for (i=1;i<=n;i++)
  {
   for (j=1;j<=n;j++)
   {
    map[i][j]=INF;//初始化
   }
  }
  for(i=1;i<=m;i++)
  {
   scanf("%d%d%d",&a,&b,&c);
   map[a][b]=map[b][a]=c;//二维数组里存着两个相连的路口
  }
  Dijkstra(n,1);
  printf("%d\n",dis[n]);
 }
 return 0;
}