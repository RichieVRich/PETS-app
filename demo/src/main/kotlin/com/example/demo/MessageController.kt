import com.pusher.rest.Pusher
    import org.springframework.http.ResponseEntity
    import org.springframework.web.bind.annotation.*

    
    @RestController
    @RequestMapping("/message")

    class MessageController {
        private val pusher = Pusher("1410249", "9ab7dccd3f9b7bea3dde", "c4847aac1939d99919d6")
    
        init {
            pusher.setCluster("us3")
        }
    
        @PostMapping
        fun postMessage(@RequestBody message: Message) : ResponseEntity<Unit> {
            pusher.trigger("chat", "new_message", message)
            return ResponseEntity.ok().build()
        }
    }
