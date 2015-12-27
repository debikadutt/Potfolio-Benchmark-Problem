import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class try5 {

	public static final String SEPARATOR = "@";
	public static final String COLON = ":";
	public static final String COMMA = ",";

	/*
	 * Complete the function below.
	 *
	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

	public static class PortfolioHolding{
		private String ticker;
		private String name;
		private int quantity;
		private double price;
		private double totalHoldingVal;

		public PortfolioHolding(String input){
			String[] pfHoldingStr = input.split(COMMA);
			this.ticker = pfHoldingStr[0];
			this.name = pfHoldingStr[1];
			this.quantity = Integer.parseInt(pfHoldingStr[2]);
			if(pfHoldingStr.length >3){
				this.price = Double.parseDouble(pfHoldingStr[3]);
			}	
		}

		public PortfolioHolding(PortfolioHolding portfolio, PortfolioHolding benchmark){		
			if(portfolio.getTicker().equals(benchmark.getTicker())){	
				this.ticker = portfolio.getTicker();				
				this.name = portfolio.getName();
				this.quantity = portfolio.getQuantity();
				this.price = benchmark.getPrice(); 
			}			
		}
		// getting all entities of the transaction
		public String getTicker(){
			return ticker;
		}

		public void setTicker(String inputTicker){
			ticker = inputTicker;        
		}

		public String getName(){
			return name;
		}

		public void setName(String inputName){
			name = inputName;        
		}

		public int getQuantity(){
			return quantity;
		}

		public void setQuantity(int inputQuantity){
			quantity = inputQuantity;        
		}	

		public double getPrice(){
			return price;
		}

		public void setPrice(double inputPrice){
			price = inputPrice;        
		}

		// calculating value and %NAV
		public double getNetVal(){
			return quantity*price;
		}

		public double getPercentVal(){
			return (this.getNetVal()/this.getTotalHoldingVal())*100;
		}

		public double getTotalHoldingVal(){
			return totalHoldingVal;
		}

		public void setTotalHoldingVal(double inputTotalHoldingVal){
			totalHoldingVal = inputTotalHoldingVal;        
		}
	}

	static HashMap<String, PortfolioHolding> generateMap(String[] inputArray) {

		HashMap<String, PortfolioHolding> showMap 
		= new HashMap<String, PortfolioHolding>();
		for(String str : inputArray){
			PortfolioHolding ph = new PortfolioHolding(str);
			showMap.put(ph.getTicker() , ph);
		}
		return showMap;
	}

	public static class Transaction implements Comparable<Transaction>{
		private String name;
		private String ticker;
		private int quantity;
		private double price;
		private double netval;
		private double totalHoldingVal;
		private double percentVal;



		public Transaction(PortfolioHolding portfolio, PortfolioHolding benchmark){

			if(portfolio.getTicker().equals(benchmark.getTicker())){	
				// Setting the ticker on the transaction 
				this.ticker = portfolio.getTicker();
				this.name = portfolio.getName();
				this.quantity = portfolio.getQuantity();
				this.totalHoldingVal = portfolio.getTotalHoldingVal();
				this.price = benchmark.getPrice();
				this.netval = portfolio.quantity * benchmark.price;
				this.percentVal = portfolio.getPercentVal();		
			}			
		}

		public String getTicker(){
			return ticker;
		}

		@Override
		public String toString(){
			return "["+this.ticker+", "+this.name+", "+this.quantity+", " 
					+String.format("%.2f",Math.abs(this.price))+", "+String.format("%.2f",Math.abs(this.netval))+", "+String.format("%.2f",Math.abs(this.percentVal))+"]";
		}        

		@Override
		public int compareTo(Transaction transObj){
			return (this.ticker.compareTo(transObj.getTicker()));
		}
	}

	static String printHoldingsWithWeight(String inputString) {
		// Splitting the input string on ':' into a portfolio and benchmark string
		String[] inputArray = inputString.split(COLON);

		// splitting the input string on '@' into a portfolio and benchmark array		
		String[] portfolioArray = inputArray[0].split(SEPARATOR);
		String[] benchmarkArray = inputArray[1].split(SEPARATOR);

		HashMap<String, PortfolioHolding> portfolioMap = generateMap(portfolioArray);
		HashMap<String, PortfolioHolding> benchmarkMap = generateMap(benchmarkArray);

		PortfolioHolding pholding = null;
		PortfolioHolding bholding = null;

		List<Transaction> transList = new ArrayList<Transaction>();
		Transaction transObj = null;

		double phTotHoldVal = 0.0;
		double bhTotHoldVal = 0.0;

		for(String key : (Set<String>)portfolioMap.keySet()){
			pholding = (PortfolioHolding) portfolioMap.get(key);
			bholding = (PortfolioHolding) benchmarkMap.get(key);

			pholding.setPrice(bholding.getPrice());

			phTotHoldVal += pholding.getNetVal();
			bhTotHoldVal += bholding.getNetVal();

		}

		for(String key : portfolioMap.keySet()){
			pholding = portfolioMap.get(key);
			bholding = benchmarkMap.get(key);

			pholding.setTotalHoldingVal(phTotHoldVal);
			bholding.setTotalHoldingVal(bhTotHoldVal);

			transObj = new Transaction(pholding, bholding);
			transList.add(transObj);
		}

		Collections.sort(transList);

		String[] resultArray = new String[transList.size()];
		// print the transaction output
		int i =0;
		for(Transaction obj : transList){
			resultArray[i] = obj.toString();
			i++;
		}
		return String.join(", ", resultArray);    
	}

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		String res;
		String _input;
		try {
			_input = in.nextLine();
		} catch (Exception e) {
			_input = null;
		}
		res = printHoldingsWithWeight(_input);
		System.out.println(res);
	}
}
