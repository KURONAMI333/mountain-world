# Mountain World — Runtime Test Checklist

Run after `./gradlew runClient` from `mod-031-mountain-world/`.

## 1. Mod load (title screen)

- [ ] Mods button → `Isekai API 1.0.0` listed
- [ ] Mods button → `Mountain World 1.0.0` listed
- [ ] No red-banner load errors

## 2. New world

- [ ] Create New World → Default → **Allow Cheats: ON**
- [ ] Game Mode: Creative
- [ ] Generate

## 3. Visual confirmation — extreme mountain terrain

- [ ] Peaks easily reach Y=250-280+ (vanilla maxes around Y=120 in plain biomes)
- [ ] Deep chasms dip below Y=0 to Y=-30 or lower
- [ ] No vast plains — every chunk has visible vertical relief

## 4. Isekai snapshot

```
/isekai stats
```
- PlacedFeatures: ~233
- Structure placements: ~34
- **Mob spawn entries: ~700+**

## 5. Structure relocation

```
/locate structure minecraft:village_plains
```
Expected: returns coordinates with Y in the **80..140** range (low valleys).

```
/locate structure minecraft:village_snowy
```
Expected: returns coordinates with Y in the **200..280** range (high glaciers).

```
/locate structure minecraft:stronghold
```
Expected: returns coordinates with Y **≤ 30** (deep chasm placement).

```
/locate structure minecraft:ocean_monument
```
Expected: **"Could not find ..."** (excluded).

## 6. Sky atmosphere

- [ ] Sky color slightly cooler than vanilla (cold high-altitude tint)
- [ ] Fog color shifts purple in the distance

## Known things

- **Spawn position**: vanilla picks via Heightmap; in extreme terrain you may
  spawn inside a wall or stranded on a peak. Use `/tp` to escape.
- **Player can fall into the void** through chasm floors — set
  `/gamerule fallDamage false` for testing if needed.
- **Stronghold finder**: `/locate` may take 20+ seconds because of the
  predicate filtering (Y ≤ 30 in mountain terrain is rare).
