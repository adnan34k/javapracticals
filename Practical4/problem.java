public class problem{
	public static void main(String [] args){
		int[] arr = {1,2,3};
		first(arr);
		last(arr);
		slast(arr);
		}
		public static void first(int arr[]){
			if(isempty(arr)){
			System.out.println("array is empty");
			System.exit(1);
			}
			else{System.out.println(arr[0]);
			}
		}
		public static void last(int arr[]){
			if(isempty(arr)){
			System.out.println("array is empty");
			System.exit(1);
			}
			System.out.println(arr[arr.length-1]);
		}
		public static void slast(int arr[]){
			if(isempty(arr)){
			System.out.println("array is empty");
			System.exit(1);
			}
			int i=0;
			while(i<arr.length-2)
			{
				i++;
			}
			System.out.println(arr[i]);
		}
		public static boolean isempty(int arr[]){
			if(arr.length<=0){
			return true;
			}
			else{
			return false;
			}
		}
	}	
