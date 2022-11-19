let tl = gsap.timeline({
    scrollTrigger: {
        trigger: ".home",
        start: "20%",
        end: "80%",
        scrub: 1,
    },
});

let tl2 = gsap.timeline({
    scrollTrigger: {
        trigger: ".home",
        start: "0%",
        end: "80%",
        scrub: 1,
    },
});


let tl3 = gsap.timeline({
    scrollTrigger: {
        trigger: ".home",
        start: "0%",
        end: "300%",
        scrub: 1,
        pin: true,
        pinSpacing: false,
    },
});
tl.fromTo(".sliding-text", {y: 0}, {y: -200});
tl2.fromTo(".home .logo", { scale: 6 }, { scale: 1, top: "1.25rem", left: "3rem", x: "50%", y: "50%" });

