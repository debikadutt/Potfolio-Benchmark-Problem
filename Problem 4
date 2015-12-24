import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class try4 {

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

		public PortfolioHolding(String input){
			String[] pfHoldingStr = input.split(COMMA);
			this.ticker = pfHoldingStr[0];
			this.name = pfHoldingStr[1];
			this.quantity = Integer.parseInt(pfHoldingStr[2]);
		}

		public PortfolioHolding(PortfolioHolding portfolio, PortfolioHolding benchmark){		
			if(portfolio.getTicker().equals(benchmark.getTicker())){	
				this.ticker = portfolio.getTicker();				
				this.name = portfolio.getName();
				this.quantity = portfolio.getQuantity();
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
		private String transType;
		private String ticker;
		private double quantity;

		public Transaction(PortfolioHolding portfolio, PortfolioHolding benchmark){

			if(portfolio.getTicker().equals(benchmark.getTicker())){	
				// Setting the ticker on the transaction 
				this.ticker = portfolio.getTicker();

				this.quantity = (benchmark.getQuantity())-(portfolio.getQuantity());

				if(portfolio.getQuantity() < benchmark.getQuantity()){
					this.transType = "BUY";					
				}
				else if(portfolio.getQuantity() > benchmark.getQuantity()){
					this.transType = "SELL";
				}	
			}			
		}

		public String getTicker(){
			return ticker;
		}

		public void setTicker(String inputTicker){
			ticker = inputTicker;        
		}

		public String getTransType(){
			return transType;
		}

		public void setTransType(String inputTransType){
			transType = inputTransType;        
		}

		public double getQuantity(){
			return quantity;
		}

		public void setQuantity(double inputQuantity){
			quantity = inputQuantity;        
		}

		@Override
		public String toString(){
			return "["+this.transType+", "+this.ticker+", "
					+String.format("%.2f",Math.abs(this.quantity))+"]";
		}        

		@Override
		public int compareTo(Transaction transObj){
			return (this.ticker.compareTo(transObj.getTicker()));
		}
	}

	static String generateTransactions(String inputString) {
		// Splitting the input string on ':' into a portfolio and benchmark string
		String[] inputArray = inputString.split(COLON);

		// splitting the input string on '@' into a portfolio and benchmark array		
		String[] portfolioArray = inputArray[0].split(SEPARATOR);
		String[] benchmarkArray = inputArray[1].split(SEPARATOR);

		HashMap<String, PortfolioHolding> portfolioMap = generateMap(portfolioArray);
		HashMap<String, PortfolioHolding> benchmarkMap = generateMap(benchmarkArray);

		PortfolioHolding phObj = null;
		PortfolioHolding bhObj = null;

		List<Transaction> transList = new ArrayList<Transaction>();
		Transaction transObj = null;

		for(String key : portfolioMap.keySet()){
			phObj = portfolioMap.get(key);
			bhObj = benchmarkMap.get(key);

			transObj = new Transaction(phObj, bhObj);
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
		res = generateTransactions(_input);
		System.out.println(res);
	}
}
