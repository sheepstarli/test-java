package lianliankan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

public class Main {

	public static void main(String[] args) {
		Lianliankan llk = new Lianliankan(new Matrix(6, 6));
		System.out.println("####################################");
		System.out.println("#                         连连看         ver 1.0              #");
		System.out.println("####################################");
		llk.print();
		while (llk.getWin() == false) {
			System.out.println("请输入你选择的点（例如,1,2,3,4）:");
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		    try {
				String inputLine=input.readLine();
				if (StringUtils.equals(inputLine, "exit")) {
					break;
				}
				String[] points = StringUtils.split(inputLine, ",");
				Integer[] p1 = new Integer[] {Integer.valueOf(points[0]), Integer.valueOf(points[1])};
				Integer[] p2 = new Integer[] {Integer.valueOf(points[2]), Integer.valueOf(points[3])};
				llk.lian(p1, p2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("游戏结束");
	}

}

class Lianliankan {
	
	private Matrix matrix;
	
	private Boolean win;
	
	private List<Integer[]> routeList = new ArrayList<Integer[]>();

	public Lianliankan(Matrix matrix) {
		this.matrix =  matrix;
		this.win = false;
	}
	
	public void print() {
		matrix.print();
	}
	
	public Boolean getWin() {
		return win;
	}
	
	public void lian(Integer[] p1, Integer[] p2) {
		if( false == checkPoint(p1, p2)) {
			matrix.print();
		} else {
			if(getRouteAndCheck(p1, p2)) {
				clearRoute();
				matrix.print();
			} else {
				System.err.println("您的输入有误，请重新选择点");
			}
		}
	}
	
	private void clearRoute() {
		Iterator<Integer[]> routeIter = routeList.iterator();
		Integer[] baseP = routeIter.next();
		while (routeIter.hasNext()) {
			Integer[] currentP = routeIter.next();
			if (baseP[0] == currentP[0]) {
				if (baseP[1] < currentP[1]) {
					for (int y = baseP[1]; y <= currentP[1]; y++) {
						if (isBound(baseP[0], y) == false) {
							matrix.set(baseP[0], y, 0);
						}
					}
				} else {
					for (int y = baseP[1]; y >= currentP[1]; y--) {
						if (isBound(baseP[0], y) == false) {
							matrix.set(baseP[0], y, 0);
						}
					}
				}
			} else {
				if (baseP[0] < currentP[0]) {
					for (int x = baseP[0]; x <= currentP[0]; x++) {
						if (isBound(x, baseP[1]) == false) {
							matrix.set(x, baseP[1], 0);
						}
					}
				} else {
					for (int x = baseP[0]; x >= currentP[0]; x--) {
						if (isBound(x, baseP[1]) == false) {
							matrix.set(x, baseP[1], 0);
						}
					}
				}
			}
			baseP = currentP;
		}
		routeList.clear();
		checkWin();
	}
	
	private void checkWin() {
		for (int x = 0; x < matrix.getXl(); x++) {
			for (int y = 0; y < matrix.getYl(); y++) {
				if (matrix.get(x, y) != 0) {
					return ;
				}
			}
		}
		win = true;
	}
	
	private boolean getRouteAndCheck(Integer[] p1, Integer[] p2) {
		if (p1[0] == p2[0] || p1[1] == p2[1]) {
			routeList.clear();
			routeList.add(p1);
			routeList.add(p2);
			if (checkRoute(routeList)) {
				return true;
			}
			if (p1[0] == p2[0]) {
				for (int x = p1[0] - 1; x >= -1; x--) {
					Integer[] mp = new Integer[] {x, p1[1]};
					if (checkRoute(getRoute(p1, p2, mp))) {
						return true;
					}
				}
				for (int x = p1[0] + 1; x <= 6; x++) {
					Integer[] mp = new Integer[] {x, p1[1]};
					if (checkRoute(getRoute(p1, p2, mp))) {
						return true;
					}
				}
			} else {
				for (int y = p1[1] - 1; y >= -1; y--) {
					Integer[] mp = new Integer[] {p1[0], y};
					if (checkRoute(getRoute(p1, p2, mp))) {
						return true;
					}
				}
				for (int y = p1[1] + 1; y <= 6; y++) {
					Integer[] mp = new Integer[] {p1[0], y};
					if (checkRoute(getRoute(p1, p2, mp))) {
						return true;
					}
				}
			}
			return false;
		} else {
			if (p1[0] > p2[0]) {
				Integer[] temp = p1;
				p1 = p2;
				p2 = temp;
			}
			for (int y = p1[1] + 1; y <= matrix.getYl() ; y++) {
				Integer[] mp = new Integer[] {p1[0], y};
				if (checkRoute(getRoute(p1, p2, mp))) {
					return true;
				}
			}
			for (int y = p1[1] - 1; y >= -1; y--) {
				Integer[] mp = new Integer[] {p1[0], y};
				if (checkRoute(getRoute(p1, p2, mp))) {
					return true;
				}
			}
			for (int x = p1[0] + 1; x <= matrix.getXl(); x++) {
				Integer[] mp = new Integer[] {x, p1[1]};
				if (checkRoute(getRoute(p1, p2, mp))) {
					return true;
				}
			}
			for (int x = p1[0] - 1; x >= -1; x--) {
				Integer[] mp = new Integer[] {x, p1[1]};
				if (checkRoute(getRoute(p1, p2, mp))) {
					return true;
				}
			}
			return false;
		}
	}
	
	private List<Integer[]> getRoute(Integer[] p1, Integer[] p2, Integer[] mp) {
		routeList.clear();
		System.out.println("获得路径开始" + " p1:" + p1[0] + "," + p1[1] + " p2:" + p2[0] + "," + p2[1] + " mp:" + mp[0] + "," + mp[1]);
		Integer[] m2p = null;
		if (mp[0] == p1[0] && mp[1] == p2[1]) {
			routeList.add(p1);
			routeList.add(mp);
			routeList.add(p2);
			return routeList;
		} else {
			routeList.add(p1);
			routeList.add(mp);
			if (p1[0] == mp[0]) {
				m2p = new Integer[] {p2[0], mp[1]};
			} else {
				m2p = new Integer[] {mp[0], p2[1]};
			}
			routeList.add(m2p);
			routeList.add(p2);
			System.out.println("获得路径开始" + " p1:" + p1[0] + "," + p1[1] + " p2:" + p2[0] + "," + p2[1] + " mp:" + mp[0] + "," + mp[1] + " m2p:" + m2p[0] + "," + m2p[1]);
			return routeList;
		}
	}
	
	private boolean checkRoute(List<Integer[]> routeList) {
		Iterator<Integer[]> pointIter = routeList.iterator();
		Integer[] basePoint = pointIter.next();
		while (pointIter.hasNext()) {
			Integer[] nextPoint = pointIter.next();
			if (basePoint[0] == nextPoint[0]) {	//两个点在同一x轴
				Integer rl = 0;
				if (basePoint[1] < nextPoint[1]) {	//base在next上面
					rl = 1;
				} else {	//base在next上面
					rl = -1;
				}
				if (basePoint[1] + rl != nextPoint[1]) {	//如果两个点没有挨着，检查纵向路径上的点
					for (int y = basePoint[1] + rl; rl == 1 ? y < nextPoint[1] : y > nextPoint[1]; y += rl ) {
						if (isBound(basePoint[0], y) == false && matrix.get(basePoint[0], y) != 0) {
							return false;
						}
					}
				} else {
					//TODO 判断途径中两个点挨着的情况
				}
			} else {	//两个点在同一y轴
				Integer rl = 0;
				if (basePoint[0] < nextPoint[0]) {	//base在next左边
					rl = 1;
				} else {	//base在next右边
					rl = -1;
				}
				if (basePoint[0] + rl != nextPoint[0]) {	//如果两个点没有挨着，检查横向路径上的点
					for (int x = basePoint[0] + rl; rl == 1 ? x < nextPoint[0] : x > nextPoint[0]; x += rl) {
						if (isBound(x, basePoint[1]) == false && matrix.get(x, basePoint[1]) != 0) {
							return false;
						}
					}
				}
			}
			basePoint = nextPoint;
		}
		return true;
	}
	
	private boolean isBound(Integer x, Integer y) {
		if (x < 0 || x >= matrix.getXl() || y < 0 || y >= matrix.getYl()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private boolean checkPoint(Integer[] p1, Integer[] p2) {
		if (p1[0] >= matrix.getXl() || p1[1] >= matrix.getYl() || p2[0] >= matrix.getXl() || p2[1] >= matrix.getYl()) {
			System.err.println("您的输入有误");
			return false;
		}
		if (matrix.get(p1[0], p1[1]) != matrix.get(p2[0], p2[1])) {
			System.err.println("嘟嘟");
			return false;
		}
		return true;
	}
}

class Matrix {
	
	private Integer xl;
	private Integer yl;
	private Integer [][] matrix;
	private static final Integer MAX_NUM = 6;
	
	public Integer getXl() {
		return xl;
	}
	
	public Integer getYl() {
		return yl;
	}
	
	public Matrix(Integer xl, Integer yl) {
		this.xl = xl;
		this.yl = yl;
		matrix = new Integer[xl][yl];
		init2();
	}
	
	public Integer get(Integer x, Integer y) {
		return matrix[x][y];
	}
	
	public void set(Integer x, Integer y, Integer value) {
		matrix[x][y] = value;
	}
	
	public void print() {
		System.out.println("    0 1 2 3 4 5 ");
		for (int i = 0; i < yl ; i++) {
			for (int t = 0; t < xl; t++) {
				if (t == 0) {
					System.out.print(i + "  ");
				}
				System.out.print(matrix[t][i] + " ");
			}
			System.out.println();
		}
	}
	
	private void init() {
		Integer total = xl * yl;
		List<Integer> cellList = new ArrayList<Integer>();
		for (int i = 0; i < total; i++) {
			cellList.add(i);
		}
		Random rd = new Random();
		Integer currentNum= MAX_NUM;
		while (total > 0 && currentNum > 1) {
			Integer count = rd.nextInt(total);
			total = total - count;
			if (cellList.size() == 0) {
				break;
			}
			for (int i = 0; i < count; i++) {
				Integer index = cellList.remove(rd.nextInt(cellList.size()));
				Integer y = index / xl;
				Integer x = index % xl;
				matrix[x][y] = currentNum;
			}
			currentNum--;
			if (currentNum == 1 && cellList.size() > 0) {
				for (Integer index : cellList) {
					Integer y = index / xl;
					Integer x = index % xl;
					matrix[x][y] = currentNum;
					System.err.println(x + " " + y + " " + currentNum);
				}
			}
		}
	}
	
	private void init2() {
		Integer total = xl * yl;
		Random rd = new Random();
		for (int i = 0; i < total; i++) {
			Integer y = i / xl;
			Integer x = i % xl;
			matrix[x][y] = rd.nextInt(MAX_NUM) + 1;
		}
		
	}
	
}
