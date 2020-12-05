package lk.ijse.instagram.instagram.controller;

import com.dramatv.dramatv.dto.authorization.AuthService;
import com.dramatv.dramatv.dto.create.CreateAdminuser;
import com.dramatv.dramatv.dto.create.CreateChannel;
import com.dramatv.dramatv.dto.create.CreateDrama;
import com.dramatv.dramatv.dto.create.CreateEpisode;
import com.dramatv.dramatv.dto.update.UpdateChannel;
import com.dramatv.dramatv.dto.update.UpdateDrama;
import com.dramatv.dramatv.dto.update.UpdateEpisode;
import com.dramatv.dramatv.entity.*;
import com.dramatv.dramatv.repository.AdminuserRepository;
import com.dramatv.dramatv.repository.ChannelRepository;
import com.dramatv.dramatv.repository.DramaRepository;
import com.dramatv.dramatv.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
public class MainController {

    @Autowired
    private AdminuserRepository adminuserRepository;


    @Autowired
    private ChannelRepository channelRepository;


    @Autowired
    private DramaRepository dramaRepository;


    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private AuthService authService;

    //Admin
    @PostMapping("/api/admin/user")
    public Adminuser adminuser(@RequestBody CreateAdminuser createAdminuser, @RequestHeader String key) {
        Adminuser adminuser = new Adminuser();
        adminuser.setName(createAdminuser.getName());
        adminuser.setUsername(createAdminuser.getUsername());
        adminuser.setPassword(createAdminuser.getPassword());
        adminuserRepository.save(adminuser);
        return adminuser;
    }


    //Channel
    @PostMapping("/api/channel")
    public Channel channel(@RequestBody CreateChannel createChannel) {

//        @RequestHeader String authorization
//        UserSession userSession = authService.validate(authorization);
        Channel channel = new Channel();

        channel.setName(createChannel.getName());
        channel.setImg(createChannel.getImg());

        channelRepository.save(channel);
        return channel;

    }

    @GetMapping("/api/channel")
    public List<Channel> getChnnels() {
//        @RequestHeader String authorization
//        UserSession userSession = authService.validate(authorization);
        return channelRepository.findAllByDeletedIsFalse();
    }


    @PutMapping("/api/channel/{id}")
    public Channel channel(@PathVariable Long id, @RequestBody UpdateChannel updateChannel) {

//        , @RequestHeader String authorization
//        UserSession userSession = authService.validate(authorization);

        Channel channel = channelRepository.findById(id).get();
        channel.setName(updateChannel.getName());
        channel.setImg(updateChannel.getImg());
        return channelRepository.save(channel);

    }

    @DeleteMapping("/api/channel/{id}")
    public void channel(@PathVariable Long id ){
//        , @RequestHeader String authorization
//        UserSession userSession = authService.validate(authorization);
        Channel channel =channelRepository.findById(id).get();
         channel.setDeleted(true);
         channelRepository.save(channel);
    }



    //Drama
    @PostMapping("/api/channel/{cid}/drama")
    public Drama drama(@PathVariable Long cid, @RequestBody CreateDrama createDrama, @RequestHeader String authorization) {
        UserSession userSession = authService.validate(authorization);
        Drama drama = new Drama();
        drama.setName(createDrama.getName());
        drama.setImg(createDrama.getImg());

        Channel channel = channelRepository.findById(cid).get();
        drama.setChannel(channel);
        dramaRepository.save(drama);
        return drama;

    }

    @GetMapping("/api/channel/{cid}/drama")
    public List<Drama> getDramas(@PathVariable Long cid , @RequestHeader String authorization) {
        UserSession userSession = authService.validate(authorization);
        return dramaRepository.findByChannelId(cid);
    }


    @PutMapping("/api/channel/{cid}/drama/{did}")
    public Drama drama(@PathVariable Long did, @RequestBody UpdateDrama updateDrama, @RequestHeader String authorization) {

        UserSession userSession = authService.validate(authorization);
        Drama drama = dramaRepository.findById(did).get();
        drama.setName(updateDrama.getName());
        drama.setImg(updateDrama.getImg());

        Channel channel = channelRepository.findById(did).get();
        drama.setChannel(channel);
        dramaRepository.save(drama);
        return drama;
    }


    //Episode
    @PostMapping("/api/drama/{did}/episode")
    public Episode episode(@PathVariable Long did, @RequestBody CreateEpisode createEpisode, @RequestHeader String authorization) {
        UserSession userSession = authService.validate(authorization);

        Episode episode = new Episode();
        episode.setName(createEpisode.getName());


        Drama drama = dramaRepository.findById(did).get();
        episode.setDrama(drama);
        episodeRepository.save(episode);
        return episode;

    }


    @GetMapping("/api/drama/{did}/episode")
    public List<Episode> getEpisodes(@PathVariable Long did, @RequestHeader String authorization) {
        UserSession userSession = authService.validate(authorization);
        return episodeRepository.findByDramaId(did);
    }


    @PutMapping("/api/drama/{did}/episode/{eid}")
    public Episode episode(@PathVariable Long eid, @RequestBody UpdateEpisode updateEpisode, @RequestHeader String authorization) {

        UserSession userSession = authService.validate(authorization);

        Episode episode = episodeRepository.findById(eid).get();
        episode.setName(updateEpisode.getName());


        Drama drama = dramaRepository.findById(eid).get();
        episode.setDrama(drama);
        return episodeRepository.save(episode);
    }


}
