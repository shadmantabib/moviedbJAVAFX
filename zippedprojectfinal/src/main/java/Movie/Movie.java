package Movie;

import java.io.Serializable;

public class Movie implements Serializable {
    public  String Title;
    public  int Year_of_Release;
    public  String Genre;
    public   int Running_Time;
    public  String Production_Company;
    public  int Budget;
    public  int Revenue;

    public String getString() {
        return Title + "," + Year_of_Release + "," + Genre + "," + Running_Time + "," + Production_Company + "," + Budget
                + "," + Revenue;
    }
    public  Movie(String Title, int Year_of_Release, String Genre, int Running_Time, String Production_Company, int Budget, int Revenue) {

        this.Title = Title;
        this.Year_of_Release = Year_of_Release;
        this.Genre = Genre;
        this.Running_Time = Running_Time;
        this.Production_Company = Production_Company;
        this.Budget = Budget;
        this.Revenue = Revenue;

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getYear_of_Release() {
        return Year_of_Release;
    }

    public void setYear_of_Release(int year_of_Release) {
        Year_of_Release = year_of_Release;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getRunning_Time() {
        return Running_Time;
    }

    public void setRunning_Time(int running_Time) {
        Running_Time = running_Time;
    }

    public String getProduction_Company() {
        return Production_Company;
    }

    public void setProduction_Company(String production_Company) {
        Production_Company = production_Company;
    }

    public long getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    public long getRevenue() {
        return Revenue;
    }

    public void setRevenue(int revenue) {
        Revenue = revenue;
    }

    //public String toString(){
    //    return "Title: "+Title+"\n"+"Realeasing Year:"+Year_of_Release+"\n"+"Genre:"+Genre+"\n"+"Running Time: "+Running_Time+"\n"+"Production Company: "+Production_Company+"\n"+"Budget: "+Budget+"\n"+"Revenue: "+Revenue ;
    //}

}
