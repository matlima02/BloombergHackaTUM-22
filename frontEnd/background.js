let particles = [];
let noiseScale = 0.01;
let number = 700;

function setup() {
    let canv = createCanvas(windowWidth, windowHeight);
    canv.style("z-index", "-1");
    canv.parent("canvas-background");

    for(let i = 0; i < number; i++){
        particles.push(createVector(random(windowWidth),random(windowHeight)));
    }
}

function windowResized() {
    resizeCanvas(windowWidth, windowHeight);
}

function draw() {
    background(0, 10);
    mousePressed();
    strokeWeight(1.5);

    for(let i = 0; i < number; i++){
        let p = particles[i];
        point(p.x, p.y);
        let n = noise(p.x * noiseScale, p.y * noiseScale);
        let a = TAU * n;
        p.x += (cos(a) * tan(a)) * 0.3;
        p.y += sin(a) * 0.3;

        if(!onScreen(p)){
            p.x = random(windowWidth);
            p.y = random(windowHeight);
        }
    }
}

function mouseMoved(){
    noiseSeed(millis());
}

function mousePressed(){
    stroke(random(frameCount * 0.5), random(40,70), random(80, 100));
}

function onScreen(v){
    return v.x >= 0 && v.x <= windowWidth && v.y >= 0 && v.y <= windowHeight;
}
