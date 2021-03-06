/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.Scanner;
 
 
/**
 *
 * @author mohamed
 */
public class ExtraCredit {
  
  private List<Iris> irisDataSet;
  private List<Iris> testDataSet;
  private List<Iris> trainingDataSet;
  private List<Iris> condensedDataSet;
  public ExtraCredit() {
    irisDataSet = new ArrayList<Iris>();
    testDataSet = new ArrayList<Iris>();
    trainingDataSet = new ArrayList<Iris>();
    condensedDataSet = new ArrayList<Iris>();
  }
  
  
  public static void main(String[] args) throws IOException{
    DataReader reader = new DataReader();
    ExtraCredit cnnImpl = new ExtraCredit();
    cnnImpl.setIrisDataSet(reader.getIrisData());
 
    cnnImpl.prepareTrainingData();
    cnnImpl.prepareTestData();
    cnnImpl.prepareCondensedSet();
    System.out.println("The condensed set is");
    for ( Iris i : cnnImpl.condensedDataSet){
      System.out.println(i);
    }
    
    double classificationAcc = cnnImpl.calculateClassificationAcc();
    System.out.println("Classification accuracy: "+classificationAcc);
 
  }
 
  private double calculateClassificationAcc(){
    double minDist = 99999;
    double correctClassification = 0.0;
    Iris closestSample = null;
 
    for ( Iris testD : testDataSet ){
      minDist = 99999;
      for ( Iris trainD : condensedDataSet){
        double calcDistance = testD.distance(trainD);
        if ( calcDistance < minDist ){
          minDist = calcDistance;
          closestSample = trainD;
        }
      }
      if ( testD.type == closestSample.type ){
        //Correct classification
        correctClassification++;
      }
    }
    System.out.println("Correct classified: "+correctClassification);
    double classAccuracy = correctClassification / (testDataSet.size());
    return classAccuracy;
  }
  public void prepareTestData(){
    
    if ( irisDataSet.size() == 150 ){
      testDataSet.addAll(irisDataSet.subList(30,50));
      testDataSet.addAll(irisDataSet.subList(80,100));
      testDataSet.addAll(irisDataSet.subList(130,150));
    }
    
  }
  public void prepareTrainingData(){
    if ( irisDataSet.size() == 150 ){
      trainingDataSet.addAll(irisDataSet.subList(0,30));//Setosa training samples
      trainingDataSet.addAll(irisDataSet.subList(50,80));//Versicolor training samples
      trainingDataSet.addAll(irisDataSet.subList(100,130));//Virginica training samples
    }
  }
 
  public void prepareCondensedSet(){
    
    //Add the first part from traning data
    condensedDataSet.add(trainingDataSet.get(0));
    
    int unchangedCount = 0;
    List<Iris> reducedSet = constructReducedSet();
    int previousReducedSetSize = 0;
    while ( true ) {
      previousReducedSetSize = reducedSet.size();
      int i = 0;
      while ( !reducedSet.isEmpty()){
        Iris ir = reducedSet.get(0);
        //Finding the closest pattern in condensed set.
        double minDist = 9999;
        IrisType type = IrisType.SETOSA;
        Iris ic = null;
        for ( int j=0; j < condensedDataSet.size(); j++){
          ic = condensedDataSet.get(j);
       
          double distBetweenPattern = ir.distance(ic);
          if ( distBetweenPattern < minDist ) {
            minDist = distBetweenPattern;
            type = ic.type;
          }
        }
        //Checking if sample in reduced set can be added to condensed set.
        if ( ir.type != type ) {
          condensedDataSet.add(ir);
        }
        reducedSet.remove(ir);  
      }
      //Generate the new reduced set
      reducedSet = constructReducedSet();
      if ( previousReducedSetSize == reducedSet.size() ){
        unchangedCount++;
      }else{
        unchangedCount = 0;
      }
      // if the reduced set is unchanged, for 2 iterations, then end the loop
      if ( unchangedCount == 2 ){
       break;
      }
    }
    
  }
  private List<Iris> constructReducedSet(){
    List<Iris> reducedSet = new ArrayList<Iris>();
    for ( Iris iTrain : trainingDataSet ){
      //If present in Condensed set, then dont add it to reducedSet.
      if ( condensedDataSet.contains(iTrain) ) {
        continue;
      }
      reducedSet.add(iTrain);
    }
    return reducedSet;
  }
 
  /**
   * @param irisDataSet the irisDataSet to set
   */
  public void setIrisDataSet(List<Iris> irisDataSet) {
    this.irisDataSet = irisDataSet;
  }
}
class DataReader{
  public List<Iris> getIrisData() throws IOException{
    Scanner irisDataReader = new Scanner(new FileReader("iris.data"));
    List<Iris> irisDataSet = new ArrayList<Iris>();
    while(irisDataReader.hasNextLine()){
      String input = irisDataReader.nextLine();
      String[] attr = null;
      if (input != null ) {
        attr = input.split(",");
      }
      if (attr != null && attr.length == 5 ) {
        IrisType type = IrisType.getType(attr[4]);
        Iris sample = new Iris(Double.parseDouble(attr[0]),
                               Double.parseDouble(attr[1]),
                               Double.parseDouble(attr[2]),
                               Double.parseDouble(attr[3]),
                               type);
        irisDataSet.add(sample);
      }
    }
    return irisDataSet;
  }
  
}
 
class Iris
{
  double sepalLength;
  double sepalWidth;
  double petalLength;
  double petalWidth;
  IrisType type;
  Iris(double sl,double sw, double pl, double pw, IrisType t)
  {
    sepalLength = sl;
    sepalWidth  = sw;
    petalLength = pl;
    petalWidth  = pw;
    type        = t;
  }
 
  @Override
  public String toString(){
    return "SL: "+sepalLength+" SW: "+sepalWidth+" PL: "+petalLength+" PW: "+petalWidth+" Type: "+type.getLabel();
  }
  
  public boolean equals(Iris other){
    return (( this.sepalLength == other.sepalLength) && 
            ( this.petalLength == other.petalLength) &&
            ( this.sepalWidth == other.sepalWidth) &&
            ( this.petalWidth == other.petalWidth) &&
            ( this.type == other.type));
  }
 
  public double distance(Iris other){
    double d1 = Math.pow((this.sepalLength - other.sepalLength),2);
    double d2 = Math.pow((this.sepalWidth - other.sepalWidth),2);
    double d3 = Math.pow((this.petalWidth - other.petalWidth),2);
    double d4 = Math.pow((this.petalLength - other.petalLength),2);
    return Math.sqrt(d1+d2+d3+d4);
  }
}
 
enum IrisType {
  SETOSA(1,"Setosa"), VERSICOLOR(2,"Versicolor"), VIRGINICA(3,"Virginica");
  private int code;
  private String label; 
  IrisType(int code, String label)
  {
    this.code = code;
    this.label = label;
  }
  public int getCode()
  {
    return this.code;
  }
  public String getLabel(){
    return this.label;
  }
  public static IrisType getType(String type)
  {
    if ( "Iris-setosa".equals(type) ){
      return SETOSA;
    }
    if ( "Iris-versicolor".equals(type)){
      return VERSICOLOR;
    }
    if ( "Iris-virginica".equals(type)){
      return VIRGINICA;
    }
    return SETOSA;
  }
}