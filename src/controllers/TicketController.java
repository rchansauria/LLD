package controllers;

import dtos.IssueTicketReponseDto;
import dtos.IssueTicketRequestDto;

public class TicketController {

    public IssueTicketReponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto){
        return new IssueTicketReponseDto();
    }
}
