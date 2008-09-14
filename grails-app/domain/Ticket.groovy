class Ticket {
    static hasMany = [changes:Change]
    User owner
    User reportedBy
    String description
    String title
    Flow flow
    Long state // the state in the flow
}
