package HackerRank_Challenges;

/**
 * Time To Words HackerRank problem
 * Given a numerical time transformed into to "words" time
 *
 * Example input
 *     5
 *     47
 *
 * Expected output
 *     thirteen minutes to six
 */

public class TimeToWords {

    private static final String [] hours = {" one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
                                " eleven", " twelve"};


    private static final String [] minutes = {" one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
            " eleven", " twelve",  " thirteen", " fourteen", " fifteen"," sixteen", " seventeen", " eighteen", " nineteen", "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight",
            "twenty nine"};



    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {

        String hourToWords;

        switch (m) {

            case 00:
                hourToWords = hours[h - 1] + " o' clock";
                break;

            case 15:
                hourToWords = "Quarter past " + hours[h - 1];
                break;

            case 30:
                hourToWords = "Half past " + hours[h - 1];
                break;

            case 45:
                hourToWords = "Quarter to " + hours[h];
                break;

            default:
                if (m < 30){
                        hourToWords = minutes[m - 1] + " minutes past" + hours[h - 1];
                } else {
                    hourToWords = minutes[(60 - m) - 1] + " minutes to" + hours[h];
                }
                break;
        }

        return hourToWords;
    }


    public static void main(String[] args) {

        int h = 7;
        int m = 29;

        System.out.println(timeInWords(h,m));
    }
}