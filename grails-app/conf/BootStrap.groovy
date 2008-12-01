import org.apache.commons.codec.digest.DigestUtils;

class BootStrap {
  def init = {servletContext ->
    def pass = DigestUtils.md5Hex("pass")
    def person = new Person(username: "tbatchelli", userRealName: "Antoni Batchelli",
            email: "tbatchelli@acm.org", description: "tbatchelli's account",
            passwd: pass, enabled: true).save()
    def admin = new Person(username: "admin", userRealName: "Administrator",
            email: "tbatchelli@acm.org", description: "Our admin", passwd: pass,
            enabled: true).save()
    def userAuth = new Authority(authority: "ROLE_USER", description: "Authenticated User").save()
    def su = new Authority(authority: "ROLE_ADMIN", description: "Administrator Role").save()
    userAuth.addToPeople(person)
    su.addToPeople(admin)
    new Requestmap(url: "/", configAttribute: "IS_AUTHENTICATED_ANONYMOUSLY").save()
    new Requestmap(url: "/login/**", configAttribute: "IS_AUTHENTICATED_ANONYMOUSLY").save()
    new Requestmap(url: "/**", configAttribute: "IS_AUTHENTICATED_FULLY").save()
  }
  def destroy = {
  }
} 