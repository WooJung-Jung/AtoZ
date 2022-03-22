package project;

public class CommandFactory {
    static Command createCommand(CmdInfo cmdInfo, Searcher searcher) {
        switch (cmdInfo.command) {
            case "ADD": return new AddCommand();
            case "DEL": return new DelCommand(searcher);
            case "SCH": return new SearchCommand(searcher);
            case "MOD": return new ModifyCommand(searcher);
        }
        return null;
    }
}
