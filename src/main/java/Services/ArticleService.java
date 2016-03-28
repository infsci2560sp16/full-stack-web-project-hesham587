package Services;

import java.util.*;

public class ArticleService {
    private static HashMap<String, String> article ;
    private static ArrayList<Map<String, String>> arrayList ;
    private LinkedList<String> ArticleIDs  = new LinkedList<>();// {"00001", "00002"};
   // private String[] BooksNames = {"Engineering Psychology and Human Performance", "Some Book"};
    private LinkedList<String> ArticleTitle  = new LinkedList<>();
    //private String[] BooksAuthors = {"Christopher D. Wickens , Justin G. Hollands, Simon Banbury, Raja Parasuraman", "Many Authors"};
    private LinkedList<String> ArticleAuthors  = new LinkedList<>();
   // private String[] BooksCondition = {"New", "Used - Very Good"};
    //private LinkedList<String> BooksCondition  = new LinkedList<>();
   // private String[] BooksUniversity = {"University of Pittsburgh", "CMU"};
   // private LinkedList<String> BooksUniversity  = new LinkedList<>();
   // private String[] BooksSchool = {"School of Information Science", "CS"};
    private LinkedList<String> ArticleDate  = new LinkedList<>();
   // private String[] BooksDescription = {"Forming connections between human performance and design Engineering Psychology and Human"
    //        + " Performance, 4e examines human-machine interaction. The book is organized directly from the psychological "
    //        + "perspective of human information processing. The chapters generally correspond to the flow of information as it is "
    //        + "processed by a human being--from the senses, through the brain, to action--rather than from the perspective of "
    //        + "system components or engineering design concepts. This book is ideal for a psychology student, engineering student, "
     //       + "or actual practitioner in engineering psychology, human performance, and human factors Learning Goals Upon "
    //        + "completing this book, readers should be able to: * Identify how human ability contributes to the design of "
    //        + "technology. * Understand the connections within human information processing and human performance. * Challenge the"
    //        + " way they think about technology's influence on human performance. * show how theoretical advances have been, or "
    //        + "might be, applied to improving human-machine interaction", "Test Description"};
    private LinkedList<String> ArticleBody  = new LinkedList<>();
    //private String[] BooksISBN13 = {"978-0205021987", "111-2233445566"};
   // private LinkedList<String> BooksISBN13  = new LinkedList<>();
    //private String[] BooksISBN10 = {"0205021980", "1122334455"};
    //private LinkedList<String> BooksISBN10  = new LinkedList<>();
   // private String[] ArticleImages = {"book1.jpg", "Book.JPG"};
    private LinkedList<String> ArticleImages  = new LinkedList<>();
    //private String[] BooksCourse = {"Human Factors in System Design", "Course Name"};
    //private LinkedList<String> BooksCourse  = new LinkedList<>();
    
    public ArticleService(){
        ArticleIDs.add("0001");
       ArticleIDs.add("0002");
        
        ArticleTitle.add("Selfie + money + Snapchat = robbed! Don't flash your cash...");
        ArticleTitle.add("Police destroy evidence with 10 failed passcode attempts on iPhone");
        
        ArticleAuthors.add("Paul Ducklin");
        ArticleAuthors.add("Lisa Vaas");
        
      //  BooksCondition.add("New");
        //BooksCondition.add("Used - Very Good");
        
        //BooksUniversity.add("University of Pittsburgh");
        //BooksUniversity.add("CMU");
        
        ArticleDate.add("September 24, 2014");
        ArticleDate.add("September 18, 2014");
        
        ArticleBody.add("Not that you might fall off a cliff, or get eaten by a shark, or run over by a train while "
		+ " posing for that 1,000,000-clicks selfie shot, although those are all risks to be aware of. The problem is the "
		+ " casually-taken selfie that gets just one view by the wrong person. One lousy, single, solitary view by someone "
		+ " who figures that he wants what you've got in the picture.Like a wedge of cash to which you proudly drew the world's "
		+ " attention.That's apparently what happened to a youngster in Florida, who posted a happy snap of himself with $280" 
		+ " in readies only to find himself at the pointy end of an intruder's knife.");
        ArticleBody.add("In January 2014, a Massachusetts cop was swearing into his mobile phone while working a traffic "
		+ " detail at a construction site.The F bombs appeared to upset an elderly lady walking by, so a man on a nearby "
		+ " front porch asked the officer, Thomas Barboza, to stop swearing.");
        
       // BooksISBN13.add("978-0205021987");
        //BooksISBN13.add("111-2233445566");
        
        //BooksISBN10.add("0205021980");
        //BooksISBN10.add("1122334455");
        
        ArticleImages.add("snap.png");
        ArticleImages.add("banana.png");
        
       // BooksCourse.add("Human Factors in System Design");
        //BooksCourse.add("Course Name");
    }
    public ArrayList<Map<String, String>> getAllArticle(){
        
        arrayList = new ArrayList<>();
        int length = 2;
        length = length + 5;
        for (int i = 0; i < length; i++) {
             
            article = new HashMap<String, String>();
            /*
            if(i <= 2){
                article.put("ArticleIDs",ArticleIDs.get(0));
                article.put("ArticleTitle",ArticleTitle.get(0));
                article.put("ArticleDate",ArticleDate.get(0));
                article.put("ArticleImages",ArticleImages.get(0));
                article.put("ArticleBody",ArticleBody.get(0)); 
				       article.put("ArticleAuthors",ArticleAuthors.get(0)); 
            }else{
				
                  article.put("ArticleIDs",ArticleIDs.get(1));
                article.put("ArticleTitle",ArticleTitle.get(1));
                article.put("ArticleDate",ArticleDate.get(1));
                article.put("ArticleImages",ArticleImages.get(1));
                article.put("ArticleBody",ArticleBody.get(1)); 
				 article.put("ArticleAuthors",ArticleAuthors.get(1)); 
            } */
		
		
            
         
                article.put("ArticleIDs",ArticleIDs.get(i));
                article.put("ArticleTitle",ArticleTitle.get(i));
                article.put("ArticleDate",ArticleDate.get(i));
                article.put("ArticleImages",ArticleImages.get(i));
                article.put("ArticleBody",ArticleBody.get(i)); 
				       article.put("ArticleAuthors",ArticleAuthors.get(i)); 
         
            arrayList.add(article);
        
        
        
        
}
	return arrayList;
	}
    
    public ArrayList<Map<String, String>> getOneArticle(String id){
        arrayList = new ArrayList<>();
        if(!id.equals("")){

            int length = ArticleIDs.size();
            for (int i = 0; i<length; i++){
                if(id.equals(ArticleIDs.get(i))){
					
                    article = new HashMap<String, String>();
					
                    article.put("ArticleIDs",ArticleIDs.get(i));
                    article.put("ArticleTitle",ArticleTitle.get(i));
                    article.put("ArticleAuthors",ArticleAuthors.get(i));
                    article.put("ArticleBody",ArticleBody.get(i));
                    article.put("ArticleDate",ArticleDate.get(i));
                    article.put("ArticleImages",ArticleImages.get(i));
                    
                    arrayList.add(article);
            
    }

            }
        
        }
        return arrayList;
    
	}
	}


