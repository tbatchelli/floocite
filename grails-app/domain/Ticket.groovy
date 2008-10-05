class Ticket {
    static hasMany = [changes:Change]
    User owner
    User reportedBy
    String description
    String title
 // the state in the flow
    Flow flow
}
