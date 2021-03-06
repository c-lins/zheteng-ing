#[ Hystrix-wiki](https://github.com/Netflix/Hystrix/wiki)

Hystrix通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力，阻止故障的连锁反应，并允许你快速失败并迅速恢复。
Hystrix是Netflix针对微服务分布式系统的熔断保护中间件，当我们的客户端连接远程的微服务时，有两种情况需要考虑：首先，如果远程系统宕机了我们怎么办？其次，我们如何管理对远程微服务的调用性能，以保证每个微服务以最小延迟最快性能响应？
Hystrix是一个有关延迟和失败容错的开源库包，用来设计隔离访问远程系统端点或微服务等，防止级联爆炸式的失败，也就是由一个小问题引起接二连三扩大的疯狂的错误爆炸直至整个系统瘫痪，能够让复杂的分布式系统更加灵活具有弹性。