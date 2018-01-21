/**
 * Created by mimtiaze on 13-Aug-16.
 */
public class NumberingAndChooseTheBestRoutine {
    public NumberingAndChooseTheBestRoutine(){
        CompleteRoutineStructureHavingOnlyIndexValue temp=AutoGenerateAllPossibleRoutine.routineHeadPointer;
        int tempCounter=0;
        while(temp!=null){

            System.out.print(tempCounter+++": ");


            for(int i=0;i<AutoGenerateAllPossibleRoutine.facultyCounter;i++){
                int facultyIndex=temp.routines[i][0];
                if(facultyIndex!=-1){
                    System.out.println(AutoGenerateAllPossibleRoutine.faculties[facultyIndex].facultyName);
                }
                for(int j=1;j<20;j++){
                    if(temp.routines[i][j]!=-1){
                        int courseIndex=temp.routines[i][j];
                        System.out.println(AutoGenerateAllPossibleRoutine.courses[courseIndex].title+" "+AutoGenerateAllPossibleRoutine.courses[courseIndex].time+" Section: "+AutoGenerateAllPossibleRoutine.courses[courseIndex].section+" Day: "+AutoGenerateAllPossibleRoutine.courses[courseIndex].day);
                    }
                }
                System.out.println();

            }
            System.out.println();
            System.out.println();
            System.out.println();

            temp=temp.next;
        }
    }
}
